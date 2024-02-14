package com.xiangxiang.yuoj.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xiangxiang.yuoj.annotation.AuthCheck;
import com.xiangxiang.yuoj.common.BaseResponse;
import com.xiangxiang.yuoj.common.ErrorCode;
import com.xiangxiang.yuoj.common.ResultUtils;
import com.xiangxiang.yuoj.constant.UserConstant;
import com.xiangxiang.yuoj.exception.BusinessException;
import com.xiangxiang.yuoj.model.dto.question.QuestionQueryRequest;
import com.xiangxiang.yuoj.model.dto.questionsubmit.QuestionSubmitAddRequest;
import com.xiangxiang.yuoj.model.dto.questionsubmit.QuestionSubmitQueryRequest;
import com.xiangxiang.yuoj.model.entity.Question;
import com.xiangxiang.yuoj.model.entity.QuestionSubmit;
import com.xiangxiang.yuoj.model.entity.User;
import com.xiangxiang.yuoj.model.vo.QuestionSubmitVO;
import com.xiangxiang.yuoj.service.QuestionSubmitService;
import com.xiangxiang.yuoj.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 题目提交接口
 */
@RestController
@RequestMapping("/question_submit")
@Slf4j
public class QuestionSubmitController {

    @Resource
    private QuestionSubmitService questionSubmitService;

    @Resource
    private UserService userService;

    /**
     * 点赞 / 取消点赞
     *
     * @param questionSubmitAddRequest
     * @param request
     * @return 提交记录的 id
     */
    @PostMapping("/")
    public BaseResponse<Long> doQuestionSubmit(@RequestBody QuestionSubmitAddRequest questionSubmitAddRequest,
                                         HttpServletRequest request) {
        if (questionSubmitAddRequest == null || questionSubmitAddRequest.getQuestionId() <= 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        // 登录才能点赞
        final User loginUser = userService.getLoginUser(request);
        long questionSubmitId = questionSubmitService.doQuestionSubmit(questionSubmitAddRequest, loginUser);
        return ResultUtils.success(questionSubmitId);
    }

    /**
     * 分页获取题目提交列表（除了管理员，普通用户只能看到非答案的公开信息）
     *
     * @param questionSubmitQueryRequest
     * @return
     */
    @PostMapping("/list/page")
    public BaseResponse<Page<QuestionSubmitVO>> listQuestionSubmitByPage(@RequestBody QuestionSubmitQueryRequest questionSubmitQueryRequest, HttpServletRequest request) {
        long current = questionSubmitQueryRequest.getCurrent();
        long size = questionSubmitQueryRequest.getPageSize();
        // 从数据库中查询原始的题目提交
        Page<QuestionSubmit> questionSubmitPage = questionSubmitService.page(new Page<>(current, size),
                questionSubmitService.getQueryWrapper(questionSubmitQueryRequest));
        final User loginUser = userService.getLoginUser(request);
        // 返回脱敏信息
        return ResultUtils.success(questionSubmitService.getQuestionSubmitVOPage(questionSubmitPage,loginUser));
    }

}

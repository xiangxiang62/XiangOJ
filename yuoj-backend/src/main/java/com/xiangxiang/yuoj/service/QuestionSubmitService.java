package com.xiangxiang.yuoj.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xiangxiang.yuoj.model.dto.question.QuestionQueryRequest;
import com.xiangxiang.yuoj.model.dto.questionsubmit.QuestionSubmitAddRequest;
import com.xiangxiang.yuoj.model.dto.questionsubmit.QuestionSubmitQueryRequest;
import com.xiangxiang.yuoj.model.entity.Question;
import com.xiangxiang.yuoj.model.entity.QuestionSubmit;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xiangxiang.yuoj.model.entity.User;
import com.xiangxiang.yuoj.model.vo.QuestionSubmitVO;
import com.xiangxiang.yuoj.model.vo.QuestionVO;

import javax.servlet.http.HttpServletRequest;

/**
* @author Administrator
* @description 针对表【question_submit(题目提交)】的数据库操作Service
* @createDate 2024-02-14 15:48:24
*/
public interface QuestionSubmitService extends IService<QuestionSubmit> {

    /**
     * 题目提交信息
     *
     * @param questionSubmitAddRequest
     * @param loginUser
     * @return
     */
    long doQuestionSubmit(QuestionSubmitAddRequest questionSubmitAddRequest, User loginUser);


    /**
     * 获取查询条件
     *
     * @param questionSubmitQueryRequest
     * @return
     */
    QueryWrapper<QuestionSubmit> getQueryWrapper(QuestionSubmitQueryRequest questionSubmitQueryRequest);


    /**
     * 获取题目封装
     *
     * @param questionSubmit
     * @param loginUser
     * @return
     */
    QuestionSubmitVO getQuestionSubmitVO(QuestionSubmit questionSubmit, User loginUser);

    /**
     * 分页获取题目封装
     *
     * @param questionSubmitService
     * @param loginUser
     * @return
     */
    Page<QuestionSubmitVO> getQuestionSubmitVOPage(Page<QuestionSubmit> questionSubmitService, User loginUser);
}

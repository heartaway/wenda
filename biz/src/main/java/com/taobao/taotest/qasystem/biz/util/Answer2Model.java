package com.taobao.taotest.qasystem.biz.util;

import com.taobao.taotest.qasystem.biz.domain.AnswerDO;
import com.taobao.taotest.qasystem.biz.model.AnswerModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: xinyuan.ymm
 * Date: 12-11-22
 * Time: 上午9:46
 * To change this template use File | Settings | File Templates.
 */
public class Answer2Model {

    public static List<AnswerModel> answerList2AnswerModelList(List<AnswerDO> answerDOList) {
        List<AnswerModel> answerModelList = new ArrayList<AnswerModel>();
        for (AnswerDO answerDO : answerDOList) {
            AnswerModel answerModel = new AnswerModel();
            answerModel.setAnswerContent(answerDO.getContent());
            answerModel.setBadCount(answerDO.getBadCount());
            answerModel.setGoodCount(answerDO.getGoodCount());
            answerModel.setQuestionId(answerDO.getQuestionId());
            answerModel.setCommentCount(answerDO.getCommentCount());
            answerModel.setCreateTime(answerDO.getGmtCreate());
            answerModelList.add(answerModel);
        }
        return answerModelList;
    }
}

function attention(questionId, uid) {
    if (uid == null || uid == "null") {
        alert("亲，你还没有登录哟！");
        return;
    }
    var tag = '#J_attention_' + questionId;
    var status = $(tag).attr('data-isattention');
    var url;
    if (status == 0) {
        url = "addAttention.htm?questionId=" + questionId + "&userId=" + uid;
    } else if (status == 1) {
        url = "delAttention.htm?questionId=" + questionId + "&userId=" + uid;
    } else {
        return;
    }

    var data = {};
    $.ajax({
        type:'POST',
        cache:false,
        url:url,
        data:data,
        timeout:5000,
        dataType:'json',
        success:function (data) {
            var response = eval(data);
            var attentionCount = response.attentionCount;
            var myAttentionCount = response.myAttentionCount;
            if (status == 0 && response.success) {
                document.getElementById('J_attention_' + questionId).attributes["data-isattention"].value = "1";
                document.getElementById('J_attention_' + questionId).innerHTML = "取消关注 " + attentionCount;
                document.getElementById('myAttentionCount').innerHTML = myAttentionCount;
                if (document.getElementById('J_attention_label_' + questionId)) {
                    document.getElementById('J_attention_label_' + questionId).innerHTML = attentionCount;
                }
            } else if (status == 1 && response.success) {
                document.getElementById('J_attention_' + questionId).attributes["data-isattention"].value = "0";
                document.getElementById('J_attention_' + questionId).innerHTML = "我要关注 " + attentionCount;
                document.getElementById('myAttentionCount').innerHTML = myAttentionCount;
                if (document.getElementById('J_attention_label_' + questionId)) {
                    document.getElementById('J_attention_label_' + questionId).innerHTML = attentionCount;
                }
            } else {
                alert("系统出现异常：数据添加失败");
            }
        },
        error:function () {
            alert('添加关注失败');
        }
    });
}


function sameAsk(questionId, uid) {
    if (uid == null || uid == "null") {
        alert("亲，你还没有登录哟！");
        return;
    }
    var tag = '#J_sameAsk_' + questionId;
    var status = $(tag).attr('data-ischoose');
    if (status == 1) {
        alert("你已经同问过这个问题了。");
        return;
    }
    var url = "sameAsk.htm?questionId=" + questionId + "&userId=" + uid;
    var data = {};
    $.ajax({
        type:'POST',
        cache:false,
        url:url,
        data:data,
        timeout:5000,
        dataType:"json",
        success:function (data) {
            var response = eval(data);
            if (response.success) {
                var sameAskCount = response.sameAskCount;
                document.getElementById('J_sameAsk_' + questionId).innerHTML = sameAskCount + "  人同问";
                $(tag).attr('data-ischoose', '1');
            } else {

                $(tag).attr('data-ischoose', '1');
                alert(response.message);
            }

        },
        error:function () {
            alert('同问失败');
        }
    });
}


function goodComment(answerId, uid) {
    if (uid == null || uid == "null") {
        alert("亲，你还没有登录哟！");
        return;
    }
    //这里 好评和差评需要互斥，也就是 好评了就不能再差评（每个答案只能评价一次）
    var tag = '#J_goodComment_' + answerId;
    var status = $(tag).attr('data-ischoose');
    if (status == 1) {
        alert("你已经评价过了哟。");
        return;
    }
    var url = "goodComment.htm?answerId=" + answerId + "&userId=" + uid;
    var data = {};
    $.ajax({
        type:'POST',
        cache:false,
        url:url,
        data:data,
        timeout:5000,
        dataType:'json',
        success:function (data) {
            var response = eval(data);
            if (response.success) {
                var goodCommentCount = response.goodCommentCount;
                document.getElementById('J_goodComment_' + answerId).innerHTML = goodCommentCount;
                $(tag).attr('data-ischoose', '1');
            } else {
                $(tag).attr('data-ischoose', '1');
                alert(response.message);
            }
        },
        error:function () {
            alert('添加评价失败');
        }
    });
}


function badComment(answerId, uid) {
    if (uid == null || uid == "null") {
        alert("亲，你还没有登录哟！");
        return;
    }
    var tag = '#J_badComment_' + answerId;
    var status = $(tag).attr('data-ischoose');
    if (status == 1) {
        alert("你已经评价过了哟。");
        return;
    }
    var url = "badComment.htm?answerId=" + answerId + "&userId=" + uid;
    var data = {};
    $.ajax({
        type:'POST',
        cache:false,
        url:url,
        data:data,
        timeout:5000,
        dataType:'json',
        success:function (data) {
            var response = eval(data);
            if (response.success) {
                var badCommentCount = response.badCommentCount;
                document.getElementById('J_badComment_' + answerId).innerHTML = badCommentCount;
                $(tag).attr('data-ischoose', '1');
            } else {
                $(tag).attr('data-ischoose', '1');
                alert(response.message);
            }
        },
        error:function () {
            alert('添加评价失败');
        }
    });
}


function loginInfo() {
    document.getElementById('loginInfo').innerHTML = "";
}


/**
 * Created by xudas on 2017/7/4.
 */
function addComment(text,id,pic) {
    if(text.length===0){
        alert('请输入评论内容')
        return;
    }
    $('#addCommitButton').attr('disabled','disabled');
    $.ajax({
        type: 'post',
        url: '/api/user/set_nickname',
        data: {
            'commentBody': text,
            'shopId':id,
            'score':10,
            'pic':pic
        },
        dataType: 'json',
        success: function (r) {
            alert('添加评论成功')

            $('#addCommitButton').removeAttr('disabled')
        }
    })
}

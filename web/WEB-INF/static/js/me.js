/**
 * UglyGroup
 * Created by xudas on 2017/6/11.
 *
 */
function startEdit() {
    $('#name-block').replaceWith(`
                <div class="input-group" style="width: 200px;left:50%;margin-left: -100px;">
                    <input id="nickname-edit" type="text" class="form-control" placeholder="">
                    <span class="input-group-btn">
                    <button id="submit-edit-nickname" class="btn btn-default" type="button" onclick="submitEdit()">✔</button>
                    </span>
                </div>`)
}
function submitEdit() {
    var newNickname = $('#submit-edit-nickname').val()
    $.ajax({
        type: 'post',
        url: '/api/user/change_nickname',
        data: {
            'username': newNickname,
        },
        dataType: 'json',
        success: function (r) {
            if (r.result){

            }else{

            }
        }
    })
}
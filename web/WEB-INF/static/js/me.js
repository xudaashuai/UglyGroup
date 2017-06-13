/**
 * UglyGroup
 * Created by xudas on 2017/6/11.
 *
 */
function startEdit() {
    $('#name-block').html(`
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
        url: '/api/user/set_nickname',
        data: {
            'newNickname': newNickname,
            'id':uid
        },
        dataType: 'json',
        success: function (r) {
            if (r.result){
                $('#name-block').html(`
                <div style="display:inline-block;">
                    <p style="color: black" class="">${user.getSign()}</p>
                </div>
                <div style="display:inline-block;" onclick="startEdit()">
                    <span class="glyphicon glyphicon-edit "/>
                </div>`)
            }else{

            }
        }
    })
}
/**
 * UglyGroup
 * Created by xudas on 2017/6/11.
 *
 */
var kw = ['', ''];
var page = [0, 0];

var ids = ['friend', 'follow']
var temp = `<div class="col-lg-3 person-item " id="{0}-item-{1}">
                                <img class="img-circle" src="{2}" alt="Generic placeholder image" width="140"
                                     height="140">
                                <h4 style="height: 40px">{3}</h4>
                                <button id="{0}-item-{1}-button" class="btn btn-success"   onclick="add({4},{5},'{0}-item-{1}')">{6}</button>
                            </div>`
String.format = function (src) {
    if (arguments.length == 0) return null;
    var args = Array.prototype.slice.call(arguments, 1);
    return src.replace(/\{(\d+)\}/g, function (m, i) {
        return args[i].toString();
    });
};

function startNicknameEdit() {
    $('#name-block').html(`
                <div class="input-group" style="width: 200px;left:50%;margin-left: -100px;">
                    <input id="nickname-edit" maxlength="15" type="text" class="form-control" placeholder="" onkeypress="if(event.keyCode===13)submitNicknameEdit();">
                    <span class="input-group-btn">
                    <button  id="submit-edit-nickname" class="btn btn-default" type="button" onclick="submitNicknameEdit()">✔</button>
                    </span>
                </div>`)
}
function submitNicknameEdit() {
    var newNickname = $('#nickname-edit').val()
    console.log(newNickname)
    $.ajax({
        type: 'post',
        url: '/api/user/set_nickname',
        data: {
            'newNickname': newNickname,
        },
        dataType: 'json',
        success: function (r) {

            $('#name-block').html(`
                <div style="display:inline-block;">
                    <h2 style="color: black">` + newNickname + `</h2></div>
                <div style="display:inline-block;" onclick="startNicknameEdit()">
                    <span class="glyphicon glyphicon-edit "/>
                </div>`)

        }
    })
}
function startSignEdit() {
    $('#sign-block').html(`
                <div class="input-group" style="width: 800px;left:50%;margin-left: -400px;">
                    <input type="text" maxlength="128" id="sign-edit" class="form-control" placeholder="" onkeypress="if(event.keyCode===13)submitSignEdit();">
                    <span class="input-group-btn">
                    <button id="submit-edit-sign" class="btn btn-default" type="button" onclick="submitSignEdit()">✔</button>
                    </span>
                </div>`)
}
function submitSignEdit() {
    var newSign = $('#sign-edit').val()
    console.log(newSign)
    $.ajax({
        type: 'post',
        url: '/api/user/set_sign',
        data: {
            'newSign': newSign,
        },
        dataType: 'json',
        success: function (r) {

            $('#sign-block').html(`
                <div style="display:inline-block;">
                <p style="color: black" class="">` + newSign + `</p>
                </div>
                <div style="display:inline-block;" onclick="startSignEdit()">
                    <span class="glyphicon glyphicon-edit "/>
                </div>`)

        }
    })
}
function searchUser(keyword, type, m, p = 0) {
    if (keyword.length < 1) {
        $('#search-' + ids[type] + '-edit').popover('show')
        return;
    }
    $('#search-' + ids[type] + '-edit').popover('hide')
    //type 0 : friend
    //type 1 : follow
    //m true
    var more = $('#search-' + ids[type] + '-more');
    var result = $('#search-' + ids[type] + '-result');
    console.log(keyword)
    $.ajax({
        type: 'post',
        url: '/api/user/search_user',
        data: {
            'keyword': keyword,
            'page': p,
            'searchWhat': ids[type]
        },
        dataType: 'json',
        success: function (r) {
            var s = '';
            var users = r['list'];
            for (var i = 0; i < users.length; i++) {
                var user = users[i];
                s += String.format(temp,
                    ids[type],
                    page[type] * 12 + i,
                    user.headPicture,
                    user.nickName,
                    type,
                    user.id,
                    type === 0 ? '添加好友' : '关注');
            }
            if (m) {
                result.html(result.html() + s);
            } else {
                result.html(s);
            }
            if (users.length < 12) {
                more.attr('onclick', '').attr('class', '').html(`<h3 style="text-align: center">没有更多了哟</h3>`)
            } else {
                more.attr('class', '').html(String.format(`<h3 style="text-align: center"><a onclick="searchUser('{0}' ,{1},true,{2})">more</a></h3>`, keyword, type, p + 1))
            }
        }
    })
}
function add(type, uuid, id) {
    if (type === 0) {
        $.ajax({
            type: 'post',
            url: '/api/message/send_message',
            data: {
                'dst':uuid,
                'type':1,
            },
            dataType:'json',
            success:function (r) {
                alert('已发送好友请求')
                $('#' + id + '-button').attr('class', 'btn btn-success disabled').html('已发送请求');
            }
        })
        return;
    }
    $.ajax({
        type: 'post',
        url: '/api/user/add_' + ids[type],
        data: {
            'id': uuid,
        },
        dataType: 'json',
        success: function (r) {
            $('#' + id + '-button').attr('class', 'btn btn-success disabled').html('已关注');
        }
    })
}
function changePassword() {
    if ($('#new-password-1').val().length < 6) {
        $('#new-password-1').popover('show')
    }
    else if ($('#new-password-1').val() != $('#new-password-2').val()) {
        $('#new-password-2').popover('show')
    } else {
        var oldPassword = $('#old-password').val()
        var newPassword = $('#new-password-1').val()
        $('#new-password-1').popover('hide')
        $('#new-password-2').popover('hide')
        $.ajax({
                type: 'post',
                url: '/api/user/set_password',
                data: {
                    'oldPassword': oldPassword,
                    'newPassword': newPassword
                },
                dataType: 'json',
                success: function (r) {
                    switch (r.status){

                    }
                }
            }
        )
    }
}
function loadFriend() {
    $.ajax({
        type: 'post',
        url: '/api/user/set_sign',
        data: {
            'newSign': newSign
        },
        dataType: 'json',
        success: function (r) {

            $('#sign-block').html(`
                <div style="display:inline-block;">
                <p style="color: black" class="">` + newSign + `</p>
                </div>
                <div style="display:inline-block;" onclick="startSignEdit()">
                    <span class="glyphicon glyphicon-edit "/>
                </div>`)

        }
    })
}
function dealFriend(mesId,id,type) {
    $.ajax({
            type: 'post',
            url: '/api/message/send_message',
            data: {
                'dst':id,
                'type':type
            },
            dataType: 'json',
            success: function (r) {
                $('#mes-friend-'+mesId.toString()+' button').html(type===2?'已同意':'已拒绝').attr('disabled','disabled')
            }
        })
    readMes(mesId)
}
function knowFans(mesId) {

    $('#mes-fans-'+mesId.toString()+' button').html('已阅').attr('disabled','disabled')
    readMes(mesId)
}
function readMes(id) {
    $.ajax({
        type: 'post',
        url: '/api/message/set_read',
        data: {
            'id':id
        },
        dataType: 'json',
        success: function (r) {
        }
    })
}

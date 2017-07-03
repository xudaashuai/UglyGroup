/**
 * Created by xudas on 2017/6/10.
 */
function tryLogin() {
    console.log('login');
    var uid = $('#login-username').val();
    var pwd = $('#login-password').val();
    $('#login-btn').html('登录中。。。');
    $('#login-btn').attr('disable','disable');
    $.ajax({
        type: 'post',
        url: '/api/user/login',
        data: {
            'username': uid,
            'password': pwd
        },
        dataType: 'json',
        success: function (r) {
            $('#login-btn').html('登录');
            $('#login-btn').attr('disable','');
            if (r.status) {
                window.location.href = '/';
            } else {
                if  (r.errorMessage === 'LOGINNAMENOEXIST'){
                    $('#login-username').popover('show')
                }else{
                    $('#login-password').popover('show')
                }
            }
        }
    })
}
function tryRegister() {
    console.log('register');
    var uid = $('#register-username').val();
    var pwd = $('#register-password').val();
    var nick = $('#register-nickname').val();
    if (uid.length <= 6 || pwd <= 6||nick<=6) {
        openAlert("用户名或密码或昵称太短（都要大于6个字符哟）");
        return;
    }
    $.ajax({
        type: 'post',
        url: '/api/user/register',
        data: {
            'nickname': nick,
            'username': uid,
            'password': pwd
        },
        dataType: 'json',
        success: function (r) {
            if (r.status) {
                $('#myTab').find('li:eq(0) a').tab('show');
                $('#login-username').val(uid);
                $('#login-password').val(pwd);
                openAlert('注册成功，请登录哟')
            }else{
                $('#register-username').popover('show')
            }
        }
    })
}
function closeAlert() {
    $("#alert").attr("class", "alert alert-danger hidden fade in");
}
function openAlert(mes) {
    console.log($('#alert').attr);
    $('#alert').html("<a onclick=\"closeAlert(this.id)\"> &times; </a>" + mes);
    $('#alert').attr("class", "alert alert-danger fade in");
}
function closeAll() {
    $('input').popover('hide')
}


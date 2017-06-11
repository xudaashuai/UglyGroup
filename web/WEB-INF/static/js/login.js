/**
 * Created by xudas on 2017/6/10.
 */
function tryLogin() {
    console.log('login');
    var uid = $('#login-username').val();
    var pwd = $('#login-password').val();
    $.ajax({
        type: 'post',
        url: '/test/login',
        data: {
            'username': uid,
            'password': pwd
        },
        dataType: 'TEXT',
        success: function (r) {
            if (r.trim() === 'ok') {
                window.location.href = '/';
            } else if(r.trim()==='le'){
                openAlert("用户名不存在")
            }else if (r.trim()==='pe'){
                openAlert("密码错误了哟")
            }else{
                openAlert("错误啦")
            }
        }
    })
}
function tryRegister() {
    console.log('register');
    var uid = $('#register-username').val();
    var pwd = $('#register-password').val();
    var nick = $('#register-nickname').val();
    $.ajax({
        type: 'post',
        url: '/test/register',
        data: {
            'nickname':nick,
            'username': uid,
            'password': pwd
        },
        dataType: 'TEXT',
        success: function (r) {
            if (r.trim() === 'ok') {
                window.location.href = '/';
            } else if(r.trim()==='le'){
                openAlert("用户名已存在");
            }
        }
    })
}
function closeAlert() {
    $("#alert").attr("class","alert alert-danger hidden fade in");
}
function openAlert(mes) {
    console.log($('#alert').attr);
    $('#alert').html("<a onclick=\"closeAlert(this.id)\"> &times; </a>"+mes);
    $('#alert').attr("class","alert alert-danger fade in");
}



/**
 * Created by xudas on 2017/6/16.
 */
function searchShop() {
    var keyword=$('#search-shop-edit').val();
    $.ajax({
        type: 'post',
        url: '/api/shop/search_shop',
        data: {
            'keyword':keyword,
        },
        dataType: 'json',
        success: function (r){

        }
    })
}
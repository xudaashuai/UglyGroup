/**
 * Created by xudas on 2017/7/6.
 */
String.format = function (src) {
    if (arguments.length === 0) return null;
    var args = Array.prototype.slice.call(arguments, 1);
    return src.replace(/\{(\d+)\}/g, function (m, i) {
        return args[i].toString();
    });
};
var temp=`
<div style="height: 500px;width: 100%;background-image:url("{3}");margin-bottom: -20px">
    <h1 style="text-align: center;padding-top: 250px"><a href="/rank?id=${0}">{1}</a></h1>
    <p style="text-align: center;">${2}</p>
    </div>
`;
function nextPage(num,keyword) {
    $.ajax({
        type: 'get',
        url: '/api/rank/get_Rank',
        data: {
            'page':num,
        },
        dataType: 'json',
        success: function (r) {
            var s="";
            var shops=r['list']
            for (var i = 0; i < shops.length; i++) {
                var shop = shops[i];
                s += String.format(temp,shop.id,shop.name,shop.introduction,shop.pic===null?"":shop.pic);
            }
            $('#recommend-list').html($('#recommend-list').html()+s);

            if (shops.length < 10) {
                $('#more-button').attr('disabled', 'disabled').html(`没有更多了哟`)
            }else{

                $('#more-button').attr('onclick','nextPage('+(num+1).toString()+')')
            }
        }
    })
}

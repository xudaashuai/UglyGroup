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
<div class="well well-lg" style="height: 400px">
                    <div class="col-md-7">
                        <a href="/shop?id={0}" style="TEXT-DECORATION:none"><h2>{1}</h2></a>
                        <p class="lead">
                                {2}
                        </p>
                    </div>
                    <div style="text-align: center;height: 500px;">
                        <div class="col-md-5" style="display: inline-block;vertical-align: middle">
                            <img src="{3}" alt="Generic placeholder image">
                        </div>
                        <span style="display: inline-block;vertical-align: middle"></span>
                    </div>
                </div>
`;
function nextPage(num,id) {
    $.ajax({
        type: 'post',
        url: '/api/rank/select_shop',
        data: {
            'page':num,
            'id':id
        },
        dataType: 'json',
        success: function (r) {
            var s="";
            var shops=r['list']
            for (var i = 0; i < shops.length; i++) {
                var shop = shops[i];
                s += String.format(temp,shop.id,shop.name,shop.simple_info===null?'':shop.simple_info.substr(0,250),shop.shopPic===null?'':shop.shopPic);
            }
            $('#recommend-list').html($('#recommend-list').html()+s);

            if (shops.length < 10) {
                $('#more-button').attr('disabled', 'disabled').html(`没有更多了哟`)
            }else{

                $('#more-button').attr('onclick','nextPage('+(num+1).toString()+','+id.toString()+')')
            }
        }
    })
}

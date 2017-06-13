/**
 * UglyGroup
 * Created by xudas on 2017/6/11.
 *
 */
function startEdit() {
    $('#name-block').replaceWith(`
                <div class="input-group" style="width: 200px;display: block">
                    <input type="text" class="form-control" placeholder="">
                    <span class="input-group-btn">
                    <button class="btn btn-default" type="button">Go!</button>
                    </span>
                </div>`)

}
/**主键ID**/
var param_id="";
/**模态框ID**/
var $confirm = $('#my-confirm');
/**模态框确定按钮**/
var $confirmBtn = $confirm.find('[data-am-modal-confirm]');
/**模态框取消按钮**/
var $cancelBtn = $confirm.find('[data-am-modal-cancel]');

/**模态框关闭事件 清除缓存**/
$confirm.on('closed.modal.amui', function() {
    $(this).removeData('amui.modal');
});

/**模态框取消按钮事件**/
$cancelBtn.off('click.cancel.modal.amui').on('click', function() {
    // do something
    $(this).removeData('amui.modal');
 });
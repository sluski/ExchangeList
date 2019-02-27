var ordersForClientList = [];

function onLoadPage() {
    console.log($('.ui-dialog-content')[0].style);
    $('.ui-dialog-content')[0].style = "max-height: " + (window.innerHeight - 78) + "px";
    console.log($('.ui-dialog-content')[0].style);
}

window.addEventListener("*", (event) => {
    console.log(event);
});

function cleanNewOrderValues() {
    $('#operations_form\\:operations_accordion_panel\\:resetNewOrderButton').click();
}

function onProductAddKeyDown(e) {
    if (e.keyCode === 13) {
        PrimeFaces.widgets.widget_operations_form_operations_accordion_panel_newProductAddButton.jq.click();
        PrimeFaces.widgets.widget_operations_form_operations_accordion_panel_newProductNameInput.jq.focus();
        e.preventDefault();
    }
}

function onClientAddKeyDown(e) {
    if (e.keyCode === 13) {
        PrimeFaces.widgets.widget_operations_form_operations_accordion_panel_newClientAddButton.jq.click();
        PrimeFaces.widgets.widget_operations_form_operations_accordion_panel_newClientNameInput.jq.focus();
        e.preventDefault();
    }
}

function focusOnNewOrderProduct() {
    setTimeout($('#operations_form\\:operations_accordion_panel\\:ordersProductAutocomplete_input')[0].focus(), 100);
}

function onOrderListChange(index) {
    if (PrimeFaces.widgets['widget_ordersListDialog_j_idt12_' + index + '_j_idt50'].input.is(':checked')) {
        $('#ordersListDialog\\:j_idt12\\:' + index + '\\:orderListElementLabel').addClass("strikeout");
    } else {
        $('#ordersListDialog\\:j_idt12\\:' + index + '\\:orderListElementLabel').removeClass("strikeout");
    }


}
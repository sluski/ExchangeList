function onLoadPage() {
    var invisibleButtons = $('.invisibleButton');
    for (var i = 0; i < invisibleButtons.length; i++) {
        invisibleButtons[i].click();
    }
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




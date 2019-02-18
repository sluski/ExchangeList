function resizeTableScroll() {
    var headerHeight = $('.ui-datatable-scrollable-header')[0].scrollHeight;
//    var footerHeight = $('.ui-datatable-scrollable-footer')[0].scrollHeight;
    var calculated = window.innerHeight - (headerHeight * 2);
    console.log("Calculated: " + calculated);
    console.log("Inner: " + window.innerHeight);
    console.log("headr: " + headerHeight);
    console.log("height: " + calculated + ";");
    $('.ui-datatable-scrollable-body')[0].attributes.style.value = "height: " + calculated + ";";
}

function onLoadPage() {
    var invisibleButtons = $('.invisibleButton');
    for (var i = 0; i < invisibleButtons.length; i++) {
        invisibleButtons[i].click();
    }
}

function cleanNewOrderValues() {
    $('#operations_form\\:operations_accordion_panel\\:resetNewOrderButton').click();
}


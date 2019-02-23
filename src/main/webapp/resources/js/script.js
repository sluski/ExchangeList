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




/**
 * 
 */

document.addEventListener("DOMContentLoaded", function () {

    const selectTipo = document.getElementById("tipo");                     
    const checkboxes = document.querySelectorAll(".corso-checkbox");        

    function aggiornaCheckbox() {
        const isStandard = selectTipo.value === "Standard";
        checkboxes.forEach(cb => {
            if (isStandard) {
                cb.checked = false;
                cb.disabled = true;
            } else {
                cb.disabled = false;
            }
        });
    }

    aggiornaCheckbox();
    selectTipo.addEventListener("change", aggiornaCheckbox);
});


/**
 * 
 */

document.addEventListener("DOMContentLoaded", function () {

    const selectTipo = document.getElementById("tipo");                     
    const checkboxes = document.querySelectorAll(".corso-checkbox");        
	const ptContainer = document.getElementById("pt-container");  // aggiunto
	const ptSelect = document.getElementById("pt-select");
	
    function aggiornaCheckbox() {
        const isAbilitato = selectTipo.value === "Premium" || selectTipo.value === "Gold" || selectTipo.value === "2";
        checkboxes.forEach(cb => {
            if (!isAbilitato) {
                cb.checked = false;
                cb.disabled = true;
            }
			else{
                cb.disabled = false;
            }
        });
    }
	
	function aggiornaPT(){
		const isGold = selectTipo.value === "Gold";
		if (!ptContainer || !ptSelect){
			//esce se non presenti container o select
			return;
		}
		if(isGold){
			ptContainer.style.display = "block";
		}
		else{
			ptContainer.style.display = "none";
		}
	}
	
    aggiornaCheckbox();
	aggiornaPT();
    selectTipo.addEventListener("change", aggiornaCheckbox);
	selectTipo.addEventListener("change", aggiornaPT);
});


document.addEventListener("DOMContentLoaded", () => {
  const select = document.getElementById("personnage-select");
  const infoDiv = document.getElementById("personnage-info");

  fetch("/api/account/getpersonnages")
    .then(response => response.json())
    .then(data => {
      // Remplit la liste déroulante
      data.forEach(p => {
        const option = document.createElement("option");
        option.value = p.name; // ou p.id si id nécessaire
        option.textContent = p.name;
        option.dataset.details = JSON.stringify(p); // Stocke les détails dans l'option
        select.appendChild(option);
      });
    });

  select.addEventListener("change", () => {
    const selectedOption = select.options[select.selectedIndex];
    if (!selectedOption.dataset.details) {
      infoDiv.innerHTML = "";
      return;
    }

    const character = JSON.parse(selectedOption.dataset.details);
    // Affiche les infos (à adapter selon ton modèle)
    infoDiv.innerHTML = `
      <strong>Nom :</strong> ${character.name}<br>
	  <strong>Skin :</strong> ${character.skin}<br>
      <strong>Niveau :</strong> ${character.level}<br>
      <strong>XP :</strong> ${character.xp} / ${character.maxXp}<br>
	  <strong>Gold :</strong> ${character.gold}<br>
	  <strong>Hp :</strong> ${character.hp} / ${character.maxHp}<br>
    `;
  });
});

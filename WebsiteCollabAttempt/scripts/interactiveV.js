"use strict";

function nextImage() {
  const nextImg = document.getElementById('imgMap');
  let src = nextImg.getAttribute('src');
  const nextDes = document.getElementById('mapCap');
  console.log(src, nextDes);
  if(src==="assets/Albuqerque_Map.png"){
		src = "assets/gusMap.png";
		nextDes.innerText="FAvoirte Laundromat: 1613 Candelaria Rd NE, Albuquerque, New Mexico 87107";
	}
   else if(src==="assets/gusMap.png"){
		src = "assets/Pollos.png";
		nextDes.innerText="Adress of his Favorite Chicken place:4257 Isleta Boulevard SW, Albuquerque, New Mexico 87105";
	}
   else {
		src="assets/Albuqerque_Map.png";
		nextDes.innerText = "Adress of his Office:9800 Montgomery Blvd NE, Albuquerque, New Mexico 87111";
   }
   
   nextImg.setAttribute('src', src);
}

function previousImage() {
  const lastImg = document.getElementById('imgMap');
  let src = lastImg.getAttribute('src');
  const nextDes = document.getElementById('mapCap');
  if (src === "assets/Pollos.png") {
		src = "assets/gusMap.png";
		nextDes.innerText="Adress: 1613 Candelaria Rd NE, Albuquerque, New Mexico 87107";
	}
	else if (src === "assets/gusMap.png") {
		src = "assets/Albuqerque_Map.png";
		nextDes.innerText = "9800 Montgomery Blvd NE, Albuquerque, New Mexico 87111";
	} 
	else {
		src = "assets/Pollos.png";
		nextDes.innerText="4257 Isleta Boulevard SW, Albuquerque, New Mexico 87105";
	}
	lastImg.setAttribute('src', src);
}


const rightButton = document.querySelector("#right");
rightButton.addEventListener("click", nextImage);
const leftButton = document.querySelector("#left");
leftButton.addEventListener("click", previousImage);

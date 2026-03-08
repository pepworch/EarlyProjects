"use strict";

/*in class quiz*/


const yesRadio = document.getElementById("yes");
const noRadio = document.getElementById("no");
const commentInput = document.getElementById("comment");
const voteButton = document.getElementById("button");
const resultBox = document.getElementById("result");


voteButton.addEventListener("click", function () {
  if (yesRadio.checked) {
    resultBox.textContent =
      "Thank you for voting yes and your comment: " + commentInput.value;
  } else if (noRadio.checked) {
    resultBox.textContent =
      "Thank you for voting no and your comment: " + commentInput.value;
  } else {
    resultBox.textContent = "Please make a selection.";
  }
});



 /* wanted posters */

const posterImages = document.querySelectorAll(".poster-img");
const posterCaptions = document.querySelectorAll(".poster-caption");

const reviews = [
  "Heisenberg's counsel: 'The chemistry was impeccable, just like my product.'",
  "My lawyer made sure the 'cap' was always off. No more methylamine worries.",
  "The chicken franchise was just a front, but his legal advice was the real deal."
];

const originalCaptions = [
  "Man with a hat.",
  "Recovering Addict.",
  "Chicken Man."
];

// click events to each poster
posterImages.forEach((image, index) => {
  image.addEventListener("click", function () {

    // /blurry to clear
    if (this.src.includes("blur-")) { // this gets the element that was clicked which is the img
      this.src = this.getAttribute("data-clear"); // set to clear image
      posterCaptions[index].textContent = reviews[index]; // show cryptic review
      posterCaptions[index].style.fontWeight = "bold";
      posterCaptions[index].style.color = "#ffea70";

    } else {
      // reset back to blurry
      this.src = this.getAttribute("data-blur"); // revert to original blur
      posterCaptions[index].textContent = originalCaptions[index]; // revert caption
      posterCaptions[index].style.fontWeight = "normal";
      posterCaptions[index].style.color = "white";
    }
  });
});



  /*loophole part that i changed to just weird laws */

  const loopholeButton = document.getElementById("loopholeButton");
  const loopholeOutput = document.getElementById("loopholeOutput");

  const loopholes = [
    "In Alabama, it's illegal to wear a fake mustache that causes laughter in church.",
    "Arizona law states that donkeys cannot sleep in bathtubs.",
    "California: No vehicle without a driver may exceed 60 miles per hour.",
    "Florida statute permits breaking a lease if the dwelling is haunted.",
    "In Georgia, it's illegal to tie a giraffe to a telephone pole.",
    "Kentucky: Every citizen must take a bath at least once a year.",
    "Massachusetts: No gorilla is allowed in the back seat of any car.",
    "Ohio law declares it illegal to get a fish drunk.",
    "Texas: Crime committed while wearing a red mask is a felony.",
    "Washington: It's illegal to pretend your parents are rich."
  ];

  loopholeButton.addEventListener("click", function () {

    const randomIndex = Math.floor(Math.random() * loopholes.length);
    const randomLoophole = loopholes[randomIndex];

    loopholeOutput.textContent = `"${randomLoophole}"`;

    // transistion to show a loophole
    loopholeOutput.style.transform = "scale(1.1)";
    loopholeOutput.style.transition = "transform 0.3s";

    setTimeout(() => {
      loopholeOutput.style.transform = "scale(1)";
    }, 300);
  });


  /*mike and huell */

  const teamCards = document.querySelectorAll(".team-card");
  const bioButtons = document.querySelectorAll(".bioButton");

  const teamBios = [
    "Huell Babineaux - Specialist in 'asset protection' and discreet transportation. Has never lost a single stack of cash.",
    "Mike Ehrmantraut - Former police officer turned investigator and fixer. Expert in surveillance and clean problem solving."
  ];

  // darken effect when hover
  teamCards.forEach(card => {
    card.addEventListener("mouseenter", function () {
      card.style.backgroundColor = "#1a1a1a";
    });

    card.addEventListener("mouseleave", function () {
      card.style.backgroundColor = "";
    });
  });

  // show/hide bios on button click
  bioButtons.forEach((btn, index) => {				// forEach is a method that loops through each item in an array
    btn.addEventListener("click", function () {
      const parentCard = btn.closest(".team-card");						// btn.closet finds the nearest ancestor (<div class="team-card">)
      const existingBio = parentCard.querySelector(".bio-text");

      if (existingBio) {
        existingBio.remove(); // Remove bio if already shown
      } else {
        const newBio = document.createElement("p");
        newBio.classList.add("bio-text");
        newBio.textContent = teamBios[index];
        newBio.style.color = "#ffea70";
        newBio.style.marginTop = "10px";
        newBio.style.backgroundColor = "#333";
        newBio.style.padding = "10px";
        newBio.style.borderRadius = "5px";
        btn.insertAdjacentElement("afterend", newBio);
      }
    });
  });

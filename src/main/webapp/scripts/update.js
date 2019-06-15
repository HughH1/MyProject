function updateTrick() {
    
    // let currentTrick = document.getElementById("trickName").innerText;
    // let currentDesc = (document.getElementById("trickDesc")).innerText;
    // let currentProgress = (document.getElementById("trickProgress")).innerText;
    // let currentDifficulty = (document.getElementById("trickDifficulty")).innerText;
    
    // document.getElementById("trickName").innerHTML = tricks.trick;
    // document.getElementById("trickDesc").innerHTML = tricks.desc;
    // document.getElementById("trickProgress").innerHTML = tricks.progress;
    // document.getElementById("trickDifficulty").innerHTML = tricks.difficulty
    let id = JSON.parse(sessionStorage.getItem("tricks"));
    trickId = id[0];
    let tricks = sessionStorage.getItem("tricks");
   
    let currentTrick = tricks.trick;
    let currentDesc = tricks.desc;
    let currentProgress = tricks.progress;
    let currentDifficulty = trick.difficulty;

    let newTrick = document.getElementById("uTrickName").value;
    let newDesc = document.getElementById("uDesc").value;
    let newProgress = document.getElementById("uProgress").value;
    let newDifficulty = document.getElementById("uDifficulty").value;

    const updatedTrick = {
        trick: (newTrick && newTrick != currentTrick) ? newTrick : currentTrick,
        desc: (newDesc && newDesc != currentDesc) ? newDesc : currentDesc,
        progress: (newProgress && newProgress != currentProgress) ? newProgress : currentProgress,
        difficulty: (newDifficulty && newDifficulty != currentDifficulty) ? newDifficulty : currentDifficulty,
    };

    console.log(updatedTrick);

    checkServer("PUT", trickId.id, "http://35.234.153.117:8080/SkateTricks-1.0/api/updateTrick",
        JSON.stringify(updatedTrick)).then((req) => {
            console.log("updated");
        });
    window.alert("Trick has been updated");
}

// let myVal = document.getElementById("theInput");

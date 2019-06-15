function searchUpdate() {
    let value = myVal.value;
    
    checkServer("GET", value, "http://35.234.153.117:8080/SkateTricks-1.0/api/viewTrickName").then((req) => {
        let tricks = JSON.parse(req.responseText);
        tricks = tricks[0]
        sessionStorage.setItem("tricks", req.responseText);

        // document.getElementById("trickName").innerHTML = tricks.trick;
        // document.getElementById("trickDesc").innerHTML = tricks.desc;
        // document.getElementById("trickProgress").innerHTML = tricks.progress;
        // document.getElementById("trickDifficulty").innerHTML = tricks.difficulty;

       
        document.getElementById("uTrickName").value = tricks.trick;
        document.getElementById("uTrickDesc").value = tricks.desc;
        document.getElementById("uTrickProgress").value = tricks.progress;
        document.getElementById("uTrickDifficulty").value = tricks.difficulty;




    });
    console.log(tricks);
    console.log(tricks.desc);
    console.log(tricks.progress);
    console.log(tricks.difficulty);
}
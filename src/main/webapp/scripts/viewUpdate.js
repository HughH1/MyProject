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
        document.getElementById("uDesc").value = tricks.desc;
        document.getElementById("uProgress").value = tricks.progress;
        document.getElementById("uDifficulty").value = tricks.difficulty;




    });
}
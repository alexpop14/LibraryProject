
fetch('http://localhost:8080/Gradle___org_example___LibraryProject_1_0_SNAPSHOT_war/members/getallmembers')
    .then(function (response) {
        return response.json();
    })
    .then(function (members) {
        showAllMembers(members);
    })
    .catch(function (err) {
        console.log('error: ' + err);
    });

function showAllMembers(members) {
    const mainContainer = document.getElementById("dropdown");
    for (var i = 0; i < members.length; i++) {
        const option = document.createElement("option");

        const memberIDs = document.createElement("textarea")
        memberIDs.innerHTML = members[i].memberID;
        memberIDs.value = members[i].memberID;
        option.appendChild(memberIDs);
        mainContainer.appendChild(option);
    }
}

function bttnFunc(){

}
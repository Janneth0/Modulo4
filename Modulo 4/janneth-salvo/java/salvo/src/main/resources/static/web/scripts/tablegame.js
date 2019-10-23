var miInit = { method: 'GET',
               };
fetch('/api/games')
.then(function(response) {
   return response.json();
})

.then (function(data){
console.log("prueba");

var addHTML = document.getElementById("gamesInfo");
console.log("prueba2");
addHTML.innerHTML = data.games.map(element =>{
console.log("prueba3");
if(element.gamePlayers.legth == 2){
jugador=element.gamePlayers.map(function(p){
return"<td>" + p.player.email + "</td>"
})
}
} )



});
/*addHTML.innerHTML = data.games.map(element => {
if(element.gamePlayers.legth == 2){
jugador=element.gamePlayers.map(function(p){
return"<td>" + p.player.email + "</td>"

}).join('')
   } else  (element.gamePlayers.legth == 1){


      jugador = element.gamePlayers.map (function(p) {
         return "<td> " +  p.player.email + "</td>"
         }).join('')


}



   return "<tr><td> " + element.id + " </td> <td>" +
   new Date(element.created).toLocaleString() +
   " </td>" + element.gamePlayers
   .map(function (p) {
      return "<td>"+ p.player.email + "</td>"
   }).join('')
 }).join(' ') +

 "</tr>";

});*/
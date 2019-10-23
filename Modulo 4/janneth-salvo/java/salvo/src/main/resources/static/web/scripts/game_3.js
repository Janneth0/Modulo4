

function leaderboard() {

    $.get('/api/leaderBoard')
        .done(function (data) {

            data.sort((a, b) => {
                return b.score.puntajeTotal - a.score.puntajeTotal
            });


            function scoreTable(data) {
                let tablaFormateada = addTableHTML(data);
                let tablaScore = document.getElementById("tablaLider");
                tablaScore.innerHTML = tablaFormateada;
            }

            function addTableHTML(data) {
                var tabla = '<thead  class="thead-dark" ><tr><th>Full Name</th><th>Total</th><th>Won</th><th>Lost</th><th>Tied</th></tr></thead>';
                tabla += "<tbody>";
                data.forEach(function (jugador) {
                    tabla += '<tr>';
                    tabla += '<td>' + jugador.userName + '</td>';
                    tabla += '<td>' + jugador.score.total + '</td>';
                    tabla += '<td>' + jugador.score.won + '</td>';
                    tabla += '<td>' + jugador.score.tied + '</td>';
                    tabla += '<td>' + jugador.score.lost + '</td>';
                    tabla += '</tr>';
                    tabla += '</tbody>';
                });
                return tabla;
            }
            scoreTable(data);
        });
}
leaderboard();

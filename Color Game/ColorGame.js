var sq = document.querySelectorAll(".square");
var res = document.getElementById("res");
var easy = document.getElementById("easy");
var hard = document.getElementById("hard");

var reset = document.getElementById("reset");

var tiles = 6;

var colors = generateRandomColors(tiles);

var ans = colors[Math.floor( Math.random()*colors.length )];

var coldisp = document.getElementById("huge");
coldisp.textContent = ans;
coldisp.style.textTransform = "uppercase";

for (var i = tiles - 1; i >= 0; i--) {
	sq[i].style.background = colors[i] ;

	sq[i].addEventListener( "click",function(){
		if( ans === this.style.background )
		{
			res.textContent = "Correct!!!";
			document.querySelector(".heading").style.backgroundColor = this.style.background;
			for (var i = tiles - 1; i >= 0; i--) {
				sq[i].style.background = ans;
			}
			reset.textContent = "Play Again?"
		}
		else
		{
			res.textContent = "Try Again";
			this.style.background = "inherit";
		}
	} )
}

reset.addEventListener("click",resetFunc );

easy.addEventListener( "click" , function(){tiles = 3;this.classList.add("selected");hard.classList.remove("selected");resetFunc();} );
hard.addEventListener( "click" , function(){tiles = 6;this.classList.add("selected");easy.classList.remove("selected");resetFunc();} );

function generateRandomColors(num)
{
	var arr = [];
	for (var i = num - 1; i >= 0; i--) 
	{
		arr.push( "rgb("+ (Math.floor( Math.random()*256 )) + ", " + (Math.floor( Math.random()*256 )) + ", " + (Math.floor( Math.random()*256 )) + ")" );
	}
	return arr;
}

function resetFunc(){
	colors = generateRandomColors(tiles);

	ans = colors[Math.floor( Math.random()*colors.length )];

	coldisp.textContent = ans;
	coldisp.style.textTransform = "uppercase";

	for (var i = sq.length - 1; i >= 0; i--) {
		sq[i].style.background = "inherit" ;
	}

	for (var i = tiles - 1; i >= 0; i--) {
		sq[i].style.background = colors[i] ;
	}
	document.querySelector(".heading").style.backgroundColor = "steelblue";
	res.textContent = "";
	reset.textContent = "New Colors";
}

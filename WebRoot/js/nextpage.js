/**
 * 
 */
function jumpTo(maxPage){
    var page = $("#jumpTo").val();
    if(page > maxPage || page < 1){
        alert("对不起，无法到达该页")
    }else{
        $('body').load('checkComments.do?page=' + page);
    }
}
/*function search123(){
	var search=document.getElementById("search").value;
	alert(search);
	window.location.href="/servlet/GoodServlet?search="+search;
}*/
function allfood(){
	var t =  document.getElementById("a").value;
	location.href="/saleOA/servlet/GoodServlet?method=AllGoods&pageNO=1&category=all";
}
function getVegetables(){
	var t =  document.getElementById("a").value;
	location.href="/saleOA/servlet/GoodServlet?method=AllGoods&pageNO=1&category=vegetable&searcht="+t;
}
function getMeat(){
	var t =  document.getElementById("a").value;
	location.href="/saleOA/servlet/GoodServlet?method=AllGoods&pageNO=1&category=meat&searcht="+t;
}
function getAtaplefood(){
	var t =  document.getElementById("a").value;
	location.href="/saleOA/servlet/GoodServlet?method=AllGoods&pageNO=1&category=main&searcht="+t;
}
function getOther(){
	 var t =  document.getElementById("a").value;
	location.href="/saleOA/servlet/GoodServlet?method=AllGoods&pageNO=1&category=other&searcht="+t;
}


function n_allfood(){
	location.href="/saleOA/servlet/GoodServlet?method=AllGoods&pageNO=1&category=all&new=is";
}
function n_getVegetables(){
	location.href="/saleOA/servlet/GoodServlet?method=AllGoods&pageNO=1&category=vegetable&new=is";
}
function n_getMeat(){
	
	location.href="/saleOA/servlet/GoodServlet?method=AllGoods&pageNO=1&category=meat&new=is";
}
function n_getAtaplefood(){
	location.href="/saleOA/servlet/GoodServlet?method=AllGoods&pageNO=1&category=main&new=is";
}
function n_getOther(){
	location.href="/saleOA/servlet/GoodServlet?method=AllGoods&pageNO=1&category=other&new=is";
}
function show(){
	
    var x=event.clientX;
    var y=event.clientY;
    document.getElementById("pic").style.top=y+50;
    document.getElementById("pic").style.left=x;
    document.getElementById("pic").style.visibility="visible";
    var formDiv="<form action='#'>";
    formDiv+="货品编号:<input type='text' name='user' /><br>";
    formDiv+="货品名称:<input type='password' name='pass' /><br><br>";     
    formDiv+="单价:<input type='password' name='pass' /><br><br>";
       formDiv+="<input type='submit' value='提交' onclick='hide()' /></form>";     
    document.getElementById("pic").innerHTML=formDiv;
}
 
function hide(){
    document.getElementById("pic").style.visibility="hidden";
}
function change(){
	location.href="/saleOA/servlet/GoodServlet?method=changejsp&id=<%g.getGoodId()%>"
}
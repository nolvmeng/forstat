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
	location.href="/saleOA/servlet/GoodServlet?method=AllGoods&pageNO=1&category=all";
}
function getVegetables(){
	location.href="/saleOA/servlet/GoodServlet?method=AllGoods&pageNO=1&category=vegetable";
}
function getMeat(){
	location.href="/saleOA/servlet/GoodServlet?method=AllGoods&pageNO=1&category=meat";
}
function getAtaplefood(){
	location.href="/saleOA/servlet/GoodServlet?method=AllGoods&pageNO=1&category=main";
}
function getOther(){
	location.href="/saleOA/servlet/GoodServlet?method=AllGoods&pageNO=1&category=other";
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


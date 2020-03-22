/*--------------------------这一部分是模板中的js---------------------------------------------*/
$(document).ready(function(){
	var $miaobian=$('.Xcontent08>div');
	var $huantu=$('.Xcontent06>img');
	var $miaobian1=$('.Xcontent26>div');
	$miaobian.mousemove(function(){miaobian(this);});
	$miaobian1.click(function(){miaobian1(this);});
	function miaobian(thisMb){
		for(var i=0; i<$miaobian.length; i++){
			$miaobian[i].style.borderColor = '#dedede';
		}
		thisMb.style.borderColor = '#cd2426';

		$huantu[0].src = thisMb.children[0].src;
	}
	function miaobian1(thisMb1){
		for(var i=0; i<$miaobian1.length; i++){
			$miaobian1[i].style.borderColor = '#dedede';
		}
//		thisMb.style.borderColor = '#cd2426';
		$miaobian.css('border-color','#dedede');
		thisMb1.style.borderColor = '#cd2426';
		$huantu[0].src = thisMb1.children[0].src;
	}
			$(".Xcontent33").click(function(){
			var value=parseInt($('.input').val())+1;
       		$('.input').val(value);
		})

		$(".Xcontent32").click(function(){	
			var num = $(".input").val()
			if(num>0){
				$(".input").val(num-1);
			}			
			
		})

		})
/*------------------------------------------------------------------------------------------------- */

//detail_addCart();

$(function(){
	detailAddCart();
})

/*加入购物车*/
function detailAddCart(){
	$(".add-cart").click(function () {
		var cartBookName = document.getElementById("cartBookName").innerText;
		var cartBookSellPrice = document.getElementById("cartBookSellPrice").innerText;
		var cartBookCount = document.getElementById("input").value;
		var cartBookDiscount = document.getElementById("cartBookDiscount").innerText;
		alert(cartBookName+cartBookSellPrice+cartBookCount+cartBookDiscount)
		var cartBookAllprice =
			parseInt(cartBookSellPrice)*parseInt(cartBookCount)*parseInt(cartBookDiscount)/10;
		alert(cartBookAllprice);

		$.ajax({
			url:"/addCartBybookDetailJsp",
			method:"POST",
			data:{
				"cartBookName":cartBookName,
				"cartBookSellPrice":cartBookSellPrice,
				"cartBookCount":cartBookCount,
				"cartBookDiscount":cartBookDiscount,
				"cartBookAllprice":cartBookAllprice
			},
			success:function () {
				alert('添加成功')
			}
		})

	});
}







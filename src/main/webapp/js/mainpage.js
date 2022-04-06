$.ajax({
	url : "category",
	type : 'post',
	data : {
		cid : 0
	},
	success : function(data) {
		$('.event_lst_txt .pink').text(data.count+"개");
	},
	error : function() {
		alert("error");
	}
});	
// 이런 식으로 jsp 파일에 jstl넣지 않고 ajax로 초기값 가져오도록 수정하도록 한다. 
$(function(){
	let banner_count = $('.visual_img').children().length;
	console.log(banner_count)
	v_width = banner_count * 414 + "px";
	$('.visual_img').css("width",v_width);
	slideShow(banner_count);
	
	tabClick();
	moreClick();
})

let Top = document.querySelector('.gototop')

Top.addEventListener('click',function(e){
    e.preventDefault();
    window.scrollTo({
        top: 0,
        behavior: "smooth"
    });
})
function slideShow(banner_count) {
	num = 1;
	setInterval(function(){
    if(num<banner_count){
	        $('.visual_img').animate({
	            left:num*(-414)
	        })
	        num+=1
	    }
	    else if (num==banner_count){
	        $('.visual_img').animate({
	            left:0
	        })
	        num=1
	    }
	},2000)
	//requestanimation으로 바꾸기
}

function tabClick(){
	let categoryId;
	// click할 때 anchor active 추가
	$('.event_tab_lst .item').click(function () { 
		$(this).parent().children('li').children().removeClass('active')
		$(this).children().addClass('active');
		categoryId = $(this).data('category')
		sendCategoryId(categoryId);
	});
}
function sendCategoryId(id){
	let count;
	$.ajax({
		url : "category",
		type : 'post',
		data : {
			cid : id
		},
		success : function(data) {
			$('.event_lst_txt .pink').text(data.count+"개");
			var left = document.querySelectorAll('.lst_event_box')[0];
			var right = document.querySelectorAll('.lst_event_box')[1];
			let leftText = [];
			let rightText = [];
			for (var i = 0; i<2;i++){
				listTemplate(data, i, leftText);
			}
			for (var i = 2, len = data.productList.length; i<len;i++){
				listTemplate(data, i, rightText);
			}
			left.innerHTML = "";
			for (var i = 0, len = leftText.length ; i < len; i++){
				left.innerHTML += leftText[i];
			}
			right.innerHTML = "";
			for (var i = 0, len =  rightText.length; i < len; i++){
				right.innerHTML += rightText[i];
			}
			count = data.count;
			countItem = $('ul.lst_event_box li.item').length
			console.log(countItem);
			console.log(data.count);
			console.log(countItem === data.totalCount);

			//남은 개수에 따라 버튼 유무
			if (data.totalCount - countItem <= 4 )
				$('.btn').css("display","none") 
			else{
				$('.btn').css("display","block");
			}
			
		},
		error : function() {
			alert("error");
		}
	});	
	return count;
}
function moreClick(){
	let categoryId = 0
	let countItem;
	$('.more .btn').click(function(){
		categoryId = $('.active').parent().data('category')
		countItem = $('ul.lst_event_box li.item').length
		console.log(categoryId);
		$.ajax({
			url : "moreItem",
			type : 'post',
			data : {
				cid : categoryId,
				citem : countItem
			},
			success : function(data) {
				var left = document.querySelectorAll('.lst_event_box')[0];
				var right = document.querySelectorAll('.lst_event_box')[1];

				let leftText = []
				let rightText = []
				if (data.productList.length <= 2){
					for (var i = 0, len = data.productList.length; i<len; i++){
						var { template, html } = listTemplate(data, i, leftText);
					}
				}
				else if (data.productList.length > 2){
					for (var i = 0; i<2; i++){						
						var { template, html } = listTemplate(data, i, leftText);
					}
					for (var i = 2, len = data.productList.length; i<len;i++){
						var { template, html } = listTemplate(data, i, rightText);					
					}
				}
				for (var i = 0, len = leftText.length ; i < len; i++){
					left.innerHTML += leftText[i];
				}
				for (var i = 0, len =  rightText.length; i < len; i++){
					right.innerHTML += rightText[i];
				}
				
				//남은 개수에 따라 버튼 유무
				if (data.totalCount - countItem <= 4 )
					$('.btn').css("display","none");
			},
			error : function() {
				alert("error");
			}
		});	
	})
}

// hanldebar로 템플릿 만들기
function listTemplate(data, i, textArr) {
	htext = $('#itemList').html();
	var template = Handlebars.compile(htext);
	var html = template(data.productList[i]);
	textArr.push(html);
	return { template, html }; //return 값은 필요없음
}

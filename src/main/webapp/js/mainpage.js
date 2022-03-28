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
				text = $('#itemList').html();
				text = text.replace('{productId}',data.productList[i].productId)
					.replaceAll('{description}',data.productList[i].description)
					.replace('{saveFileName}',data.productList[i].saveFileName)
					.replace('{placeName}',data.productList[i].placeName)
					.replace('{content}',data.productList[i].content);
				leftText.push(text);	
			}
			for (var i = 2, len = data.productList.length; i<len;i++){
				text = $('#itemList').html();
				text = text.replace('{productId}',data.productList[i].productId)
					.replaceAll('{description}',data.productList[i].description)
					.replace('{saveFileName}',data.productList[i].saveFileName)
					.replace('{placeName}',data.productList[i].placeName)
					.replace('{content}',data.productList[i].content);
				rightText.push(text);
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
				let leftText = [];
				let rightText = [];
				if (data.productList.length <= 2){
					for (var i = 0, len = data.productList.length; i<len; i++){
						text = $('#itemList').html();
						text = text.replace('{productId}',data.productList[i].productId)
							.replaceAll('{description}',data.productList[i].description)
							.replace('{saveFileName}',data.productList[i].saveFileName)
							.replace('{placeName}',data.productList[i].placeName)
							.replace('{content}',data.productList[i].content);
						leftText.push(text);	
					}
				}
				else if (data.productList.length > 2){
					for (var i = 0; i<2; i++){
						text = $('#itemList').html();
						text = text.replace('{productId}',data.productList[i].productId)
							.replaceAll('{description}',data.productList[i].description)
							.replace('{saveFileName}',data.productList[i].saveFileName)
							.replace('{placeName}',data.productList[i].placeName)
							.replace('{content}',data.productList[i].content);
						leftText.push(text);	
					}
					for (var i = 2, len = data.productList.length; i<len;i++){
						text = $('#itemList').html();
						text = text.replace('{productId}',data.productList[i].productId)
							.replaceAll('{description}',data.productList[i].description)
							.replace('{saveFileName}',data.productList[i].saveFileName)
							.replace('{placeName}',data.productList[i].placeName)
							.replace('{content}',data.productList[i].content);
						rightText.push(text);
					}
				}
				for (var i = 0, len = leftText.length ; i < len; i++){
					left.innerHTML += leftText[i];
				}
				for (var i = 0, len =  rightText.length; i < len; i++){
					right.innerHTML += rightText[i];
				}
				console.log(countItem);
				console.log(data.totalCount);
				console.log(countItem === data.totalCount);
				if (data.totalCount - countItem <= 4 )
					$('.btn').css("display","none");
			},
			error : function() {
				alert("error");
			}
		});	
	})
	
}
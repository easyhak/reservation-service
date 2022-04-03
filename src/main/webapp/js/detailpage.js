$(function(){
    /* 슬라이드 */
    let banner_count = $('.detail_swipe').children().length;
    $('.figure_pagination span.total').text(banner_count) // 위에 숫자 
	console.log(banner_count)
	v_width = banner_count * 414 + "px";
    $('.detail_swipe').css("width",v_width);
    var count = 0;
    $('.prev').click(function(){
        console.log(count);
        if(count <= 0){
            $('.visual_img').css({
                left: (-414)*banner_count
            })
            count = banner_count-1
        }
        else
            count = count - 1
        $('.visual_img').stop().animate({
            left:(-414)*count
        })
        $('.figure_pagination span.now').text(count+1);
    })
    $('.nxt').click(function(){
        console.log(count);
        if (count  >= banner_count-1){
            count = 0
            $('.visual_img').css({
                left: (414)*1
            })
        }
        else 
            count = count + 1 
        $('.visual_img').stop().animate({
            left:(-414)*count
        })
        $('.figure_pagination span.now').text(count+1);
    })

    /* 펼쳐보기 클릭 */
    $('a._open').click(function(){
        $('.section_store_details .store_details').removeClass('close3');
        $('a._open').css({
            display: "none"
        })
        $('a._close').css({
            display: "block"
        })
    })
    $('a._close').click(function(){
        $('.section_store_details .store_details').addClass('close3');
        $('a._open').css({
            display: "block"
        })
        $('a._close').css({
            display: "none"
        })
    })

    
    
    
})
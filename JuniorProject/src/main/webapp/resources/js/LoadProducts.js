$(document).ready(function() {
    $.ajax({
        url : "/juniorapp/loadproducts",
        data:{categoryId:'1'},
        contentType:"application/json",
        dataType:"json",
        type : 'GET',
        success : function(data) {
            var items=''
            var count =0;
            var box = '#imagebox1'
            //$("#imagebox").html(items);
            data.forEach(function (item,i,arr) {
                ++count
                items +='<div class="col-sm-4">'
                items +='<div class="row">'
                items+='<h1 class="text-center">'
                items+=item.name
                items+='</h1>'
                items+='</div>'
                items+='<div class="row">'
                items+='<form role="form" class="form-inline" >'
                items+='<ul class="pager">'
                items+='<li class="previous"><button type="submit" class="btn">←</button></li>'
                items+='<li><input  type="text" name="search"></li>'
                items+='<li class="next"><button type="submit" class="btn">→</button></li>'
                items+='<li><button type="submit" class="btn">+</button></li>'
                items+='</ul>'
                items+='</form>'
                items+='</div>'
                items+='</div>'
                if(count==3){
                    $(box).html(items)
                    box='#imagebox2'
                    count = 0
                    items =''
                }

            })
            $(box).html(items)
        }
    });
});


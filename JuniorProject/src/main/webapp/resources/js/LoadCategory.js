$(document).ready(function() {
    $.ajax({
        url : "/juniorapp/homepage",
        contentType:"application/json",
        dataType:"json",
        type : 'GET',
        success : function(data) {
            var items = '<ul id="menu">'
            items += '<li class="categorytitle">Категории</li>';

            $.each(data, function(key, val){
                items+='<li><a onclick="">' + val + '</a></li>';
            });
            items+='</ul>'
            $("#blockmenu").html(items);
        }
    });
});
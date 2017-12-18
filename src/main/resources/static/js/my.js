
function sendGet(url,obj) {
    $.get(url,function (data,status) {
        showData(data);
    })
}

function showData(date){
    alert(date.message);
    if(date.code==0 ){
        //
        location.replace(location+"&timestamp="+new Date());
    }
}
document.getElementById('itemForm').addEventListener("submit",function(e){

    e.preventDefault();      // UTF Decoding 방식으로 보내지 못하게 막음 (json 형식으로 데이터 보내기 위해)

    const item = {
        id: document.getElementById("item_id").value,
        item : document.getElementById("item_id").value
    }

    // json 파일로 보내겠다
    // fetch(요청주소,요청내용객체)  -> 성공, 실패 여부 판별
    fetch("/items/"+item.id+"/modify", {
      method:'post',
      headers:{"Content-type" : "application/json"},
        body: JSON.stringify(item)
    })
        .then(response =>{
                if(response.ok){
                    alert("아이템이 성공적으로 생성되었습니다.");
                    document.getElementById("itemForm").reset();
                }
                else {
                    alert("아이템 생성에 실패했습니다.");
                }
            })
        .catch( error =>{
            console.error('Error',error);
            alert("오류가 발생했습니다.");
            }
        );
})
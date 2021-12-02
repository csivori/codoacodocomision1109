const app=new Vue({
    el:"#app",
    data:{
        usuarios:[],
        errored:false,
        loading:true
    },
    created() {
        var url="http://localhost:8080/usuario"
        this.fetchData(url);
    },
    methods:{
        fetchData(url){
            fetch(url)
            .then(response => response.json())
            .then(data => {
                this.usuarios = data;
                console.log(data);
                this.loading = false;
                console.log(this.loading);
            })
            .catch(err =>{
                console.log(err);
                this.errored = true;
                console.log(this.errored);
            })

            }
        }
})
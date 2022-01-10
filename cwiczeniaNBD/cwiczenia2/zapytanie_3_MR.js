var mapFunction = function(){
	var key = this.job;
	var value = null;
	emit(key, value)};

var reduceFunction = function(key, values){
	return Array.sum(values);
};

db.people.mapReduce(mapFunction, reduceFunction, {out: "mp3"})
printjson(db.mp3.find({}).toArray())
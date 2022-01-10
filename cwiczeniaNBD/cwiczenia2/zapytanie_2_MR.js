var mapFunction = function() {
  this.credit.forEach(credit => {
    emit(credit.currency, parseFloat(credit.balance));
  });
}

var reduceFunction = function(currency, values) {
  return Array.sum(values)
}

db.people.mapReduce(mapFunction,reduceFunction, {out:"mapreduce"});
printjson(db.mapreduce.find({}).toArray())
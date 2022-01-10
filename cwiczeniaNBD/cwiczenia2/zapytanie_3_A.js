printJson(db.people.aggregate([
    { $group: { _id: null, jobs: {$addToSet: "$job" }} },
    { "$project": { jobs: true, _id:false} },
  ]).toArray())
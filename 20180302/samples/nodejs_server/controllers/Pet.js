'use strict';

var url = require('url');

var Pet = require('./PetService');

module.exports.getPetById = function getPetById (req, res, next) {
  Pet.getPetById(req.swagger.params, res, next);
};

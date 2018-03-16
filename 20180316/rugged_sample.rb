# -*- encoding: utf-8 -*-
require 'rugged'

def main
  repo = Rugged::Repository.new('../.git')
  commit = repo.head.target
  puts commit.message
  puts "#{commit.author[:name]} <#{commit.author[:email]}>"
  tree = commit.tree
  p tree
end

case $PROGRAM_NAME
when __FILE__
  main
when /spec[^\/]*$/
  # {spec of the implementation}
end


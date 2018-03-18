# -*- encoding: utf-8 -*-
require 'rugged'

def main
  repo = Rugged::Repository.new('./sub_git_repo/.git')
  commit = repo.head.target
  puts commit.message
  puts "#{commit.author[:name]} <#{commit.author[:email]}>"
  tree = commit.tree
  p tree

  p repo.exists?('07b44cbda23b726e5d54e2ef383495922c024202')

  p repo.exists?('878c156913c53033d0c4df664ed8754f6f13aee5')
end

case $PROGRAM_NAME
when __FILE__
  main
when /spec[^\/]*$/
  # {spec of the implementation}
end


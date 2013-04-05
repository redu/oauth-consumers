require 'csv'

class CSVFormatter
  def initialize(*headers)
    @headers = headers
  end

  def generate(&block)
    CSV.open("export.csv", "wb") do |file|
      file << @headers
      block.call(file) if block
    end
  end
end

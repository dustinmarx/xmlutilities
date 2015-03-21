#!/usr/bin/env groovy
/*
 * escapeXml.groovy
 *
 * Requires Groovy 2.1 or later.
 */
if (args.length < 1)
{
   println "USAGE: groovy escapeXml.groovy <xmlFileToBeProcessed>"
   System.exit(-1)
}
def inputFileName = args[0]
println "Processing ${inputFileName}..."
def inputFile = new File(inputFileName)
String outputFileName = inputFileName + ".escaped"
def outputFile = new File(outputFileName)
if (outputFile.createNewFile())
{
   outputFile.text = groovy.xml.XmlUtil.escapeXml(inputFile.text)
}
else
{
   println "Unable to create file ${outputFileName}"
}

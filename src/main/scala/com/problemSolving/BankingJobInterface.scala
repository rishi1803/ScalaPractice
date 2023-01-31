package com.problemSolving

import org.apache.spark.sql.{DataFrame, SparkSession}

trait BankingJobInterface {

  val sparkSession: SparkSession

  def read(filePath: String): DataFrame = sparkSession
    .read
    .options(Map("inferSchema" -> "true", "delimiter" -> ",", "header" -> "true"))
    .csv(filePath)

  def extractValidTransactions(accountsDf: DataFrame, transactionDf: DataFrame): DataFrame

  def distinctTransactions(transactionsDf: DataFrame): Long

  def transactionsByAccount(transactionsDf: DataFrame): DataFrame

  def stop(): Unit = sparkSession.stop()
}
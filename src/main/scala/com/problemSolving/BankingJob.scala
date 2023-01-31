package com.problemSolving

import org.apache.spark.sql.{DataFrame, SparkSession}
import org.apache.spark.sql.functions._

object BankingJob extends BankingJobInterface {
  val sparkSession: SparkSession = SparkSession
    .builder()
    .appName("Banking Data Mining")
    .master("local[*]")
    .getOrCreate()

  def extractValidTransactions(accountsDf: DataFrame, transactionDf: DataFrame): DataFrame = {


      val validDf = accountsDf.join(transactionDf, accountsDf("accountNumber") === transactionDf("toAccountNumber"))
//        .createOrReplaceTempView()
//      (transactionDf, accountsDf("accountNumber") === transactionDf("toAccountNumber"))
//        .filter(transactionDf.col("transferAmount") <== accountsDf.col("balance"))
//        .select(transactionDf.col("fromAccountNumber"),
//          transactionDf.col("toAccountNumber"),
//          transactionDf.col("transferAmount")
//        ).where(transactionDf.col("transferAmount") <== accountsDf.col("balance"))

      validDf

//    val newDf = sparkSession.sql()


  }

  def distinctTransactions(transactionsDf: DataFrame): Long = ???

  def transactionsByAccount(transactionsDf: DataFrame): DataFrame = ???
}

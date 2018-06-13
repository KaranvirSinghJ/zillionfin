// ORM class for table 'daily_stock'
// WARNING: This class is AUTO-GENERATED. Modify at your own risk.
//
// Debug information:
// Generated date: Sat Oct 28 08:51:10 PDT 2017
// For connector: org.apache.sqoop.manager.MySQLManager
import org.apache.hadoop.io.BytesWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.Writable;
import org.apache.hadoop.mapred.lib.db.DBWritable;
import com.cloudera.sqoop.lib.JdbcWritableBridge;
import com.cloudera.sqoop.lib.DelimiterSet;
import com.cloudera.sqoop.lib.FieldFormatter;
import com.cloudera.sqoop.lib.RecordParser;
import com.cloudera.sqoop.lib.BooleanParser;
import com.cloudera.sqoop.lib.BlobRef;
import com.cloudera.sqoop.lib.ClobRef;
import com.cloudera.sqoop.lib.LargeObjectLoader;
import com.cloudera.sqoop.lib.SqoopRecord;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class daily_stock extends SqoopRecord  implements DBWritable, Writable {
  private final int PROTOCOL_VERSION = 3;
  public int getClassFormatVersion() { return PROTOCOL_VERSION; }
  public static interface FieldSetterCommand {    void setField(Object value);  }  protected ResultSet __cur_result_set;
  private Map<String, FieldSetterCommand> setters = new HashMap<String, FieldSetterCommand>();
  private void init0() {
    setters.put("ID", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        ID = (Integer)value;
      }
    });
    setters.put("Date", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        Date = (java.sql.Timestamp)value;
      }
    });
    setters.put("Open", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        Open = (Double)value;
      }
    });
    setters.put("High", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        High = (Double)value;
      }
    });
    setters.put("Low", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        Low = (Double)value;
      }
    });
    setters.put("Close", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        Close = (Double)value;
      }
    });
    setters.put("Adj Close", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        AdjClose = (Double)value;
      }
    });
    setters.put("Volume", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        Volume = (Long)value;
      }
    });
    setters.put("tickt", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        tickt = (String)value;
      }
    });
    setters.put("updated_at", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        updated_at = (java.sql.Timestamp)value;
      }
    });
  }
  public daily_stock() {
    init0();
  }
  private Integer ID;
  public Integer get_ID() {
    return ID;
  }
  public void set_ID(Integer ID) {
    this.ID = ID;
  }
  public daily_stock with_ID(Integer ID) {
    this.ID = ID;
    return this;
  }
  private java.sql.Timestamp Date;
  public java.sql.Timestamp get_Date() {
    return Date;
  }
  public void set_Date(java.sql.Timestamp Date) {
    this.Date = Date;
  }
  public daily_stock with_Date(java.sql.Timestamp Date) {
    this.Date = Date;
    return this;
  }
  private Double Open;
  public Double get_Open() {
    return Open;
  }
  public void set_Open(Double Open) {
    this.Open = Open;
  }
  public daily_stock with_Open(Double Open) {
    this.Open = Open;
    return this;
  }
  private Double High;
  public Double get_High() {
    return High;
  }
  public void set_High(Double High) {
    this.High = High;
  }
  public daily_stock with_High(Double High) {
    this.High = High;
    return this;
  }
  private Double Low;
  public Double get_Low() {
    return Low;
  }
  public void set_Low(Double Low) {
    this.Low = Low;
  }
  public daily_stock with_Low(Double Low) {
    this.Low = Low;
    return this;
  }
  private Double Close;
  public Double get_Close() {
    return Close;
  }
  public void set_Close(Double Close) {
    this.Close = Close;
  }
  public daily_stock with_Close(Double Close) {
    this.Close = Close;
    return this;
  }
  private Double AdjClose;
  public Double get_AdjClose() {
    return AdjClose;
  }
  public void set_AdjClose(Double AdjClose) {
    this.AdjClose = AdjClose;
  }
  public daily_stock with_AdjClose(Double AdjClose) {
    this.AdjClose = AdjClose;
    return this;
  }
  private Long Volume;
  public Long get_Volume() {
    return Volume;
  }
  public void set_Volume(Long Volume) {
    this.Volume = Volume;
  }
  public daily_stock with_Volume(Long Volume) {
    this.Volume = Volume;
    return this;
  }
  private String tickt;
  public String get_tickt() {
    return tickt;
  }
  public void set_tickt(String tickt) {
    this.tickt = tickt;
  }
  public daily_stock with_tickt(String tickt) {
    this.tickt = tickt;
    return this;
  }
  private java.sql.Timestamp updated_at;
  public java.sql.Timestamp get_updated_at() {
    return updated_at;
  }
  public void set_updated_at(java.sql.Timestamp updated_at) {
    this.updated_at = updated_at;
  }
  public daily_stock with_updated_at(java.sql.Timestamp updated_at) {
    this.updated_at = updated_at;
    return this;
  }
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof daily_stock)) {
      return false;
    }
    daily_stock that = (daily_stock) o;
    boolean equal = true;
    equal = equal && (this.ID == null ? that.ID == null : this.ID.equals(that.ID));
    equal = equal && (this.Date == null ? that.Date == null : this.Date.equals(that.Date));
    equal = equal && (this.Open == null ? that.Open == null : this.Open.equals(that.Open));
    equal = equal && (this.High == null ? that.High == null : this.High.equals(that.High));
    equal = equal && (this.Low == null ? that.Low == null : this.Low.equals(that.Low));
    equal = equal && (this.Close == null ? that.Close == null : this.Close.equals(that.Close));
    equal = equal && (this.AdjClose == null ? that.AdjClose == null : this.AdjClose.equals(that.AdjClose));
    equal = equal && (this.Volume == null ? that.Volume == null : this.Volume.equals(that.Volume));
    equal = equal && (this.tickt == null ? that.tickt == null : this.tickt.equals(that.tickt));
    equal = equal && (this.updated_at == null ? that.updated_at == null : this.updated_at.equals(that.updated_at));
    return equal;
  }
  public boolean equals0(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof daily_stock)) {
      return false;
    }
    daily_stock that = (daily_stock) o;
    boolean equal = true;
    equal = equal && (this.ID == null ? that.ID == null : this.ID.equals(that.ID));
    equal = equal && (this.Date == null ? that.Date == null : this.Date.equals(that.Date));
    equal = equal && (this.Open == null ? that.Open == null : this.Open.equals(that.Open));
    equal = equal && (this.High == null ? that.High == null : this.High.equals(that.High));
    equal = equal && (this.Low == null ? that.Low == null : this.Low.equals(that.Low));
    equal = equal && (this.Close == null ? that.Close == null : this.Close.equals(that.Close));
    equal = equal && (this.AdjClose == null ? that.AdjClose == null : this.AdjClose.equals(that.AdjClose));
    equal = equal && (this.Volume == null ? that.Volume == null : this.Volume.equals(that.Volume));
    equal = equal && (this.tickt == null ? that.tickt == null : this.tickt.equals(that.tickt));
    equal = equal && (this.updated_at == null ? that.updated_at == null : this.updated_at.equals(that.updated_at));
    return equal;
  }
  public void readFields(ResultSet __dbResults) throws SQLException {
    this.__cur_result_set = __dbResults;
    this.ID = JdbcWritableBridge.readInteger(1, __dbResults);
    this.Date = JdbcWritableBridge.readTimestamp(2, __dbResults);
    this.Open = JdbcWritableBridge.readDouble(3, __dbResults);
    this.High = JdbcWritableBridge.readDouble(4, __dbResults);
    this.Low = JdbcWritableBridge.readDouble(5, __dbResults);
    this.Close = JdbcWritableBridge.readDouble(6, __dbResults);
    this.AdjClose = JdbcWritableBridge.readDouble(7, __dbResults);
    this.Volume = JdbcWritableBridge.readLong(8, __dbResults);
    this.tickt = JdbcWritableBridge.readString(9, __dbResults);
    this.updated_at = JdbcWritableBridge.readTimestamp(10, __dbResults);
  }
  public void readFields0(ResultSet __dbResults) throws SQLException {
    this.ID = JdbcWritableBridge.readInteger(1, __dbResults);
    this.Date = JdbcWritableBridge.readTimestamp(2, __dbResults);
    this.Open = JdbcWritableBridge.readDouble(3, __dbResults);
    this.High = JdbcWritableBridge.readDouble(4, __dbResults);
    this.Low = JdbcWritableBridge.readDouble(5, __dbResults);
    this.Close = JdbcWritableBridge.readDouble(6, __dbResults);
    this.AdjClose = JdbcWritableBridge.readDouble(7, __dbResults);
    this.Volume = JdbcWritableBridge.readLong(8, __dbResults);
    this.tickt = JdbcWritableBridge.readString(9, __dbResults);
    this.updated_at = JdbcWritableBridge.readTimestamp(10, __dbResults);
  }
  public void loadLargeObjects(LargeObjectLoader __loader)
      throws SQLException, IOException, InterruptedException {
  }
  public void loadLargeObjects0(LargeObjectLoader __loader)
      throws SQLException, IOException, InterruptedException {
  }
  public void write(PreparedStatement __dbStmt) throws SQLException {
    write(__dbStmt, 0);
  }

  public int write(PreparedStatement __dbStmt, int __off) throws SQLException {
    JdbcWritableBridge.writeInteger(ID, 1 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeTimestamp(Date, 2 + __off, 93, __dbStmt);
    JdbcWritableBridge.writeDouble(Open, 3 + __off, 8, __dbStmt);
    JdbcWritableBridge.writeDouble(High, 4 + __off, 8, __dbStmt);
    JdbcWritableBridge.writeDouble(Low, 5 + __off, 8, __dbStmt);
    JdbcWritableBridge.writeDouble(Close, 6 + __off, 8, __dbStmt);
    JdbcWritableBridge.writeDouble(AdjClose, 7 + __off, 8, __dbStmt);
    JdbcWritableBridge.writeLong(Volume, 8 + __off, -5, __dbStmt);
    JdbcWritableBridge.writeString(tickt, 9 + __off, -1, __dbStmt);
    JdbcWritableBridge.writeTimestamp(updated_at, 10 + __off, 93, __dbStmt);
    return 10;
  }
  public void write0(PreparedStatement __dbStmt, int __off) throws SQLException {
    JdbcWritableBridge.writeInteger(ID, 1 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeTimestamp(Date, 2 + __off, 93, __dbStmt);
    JdbcWritableBridge.writeDouble(Open, 3 + __off, 8, __dbStmt);
    JdbcWritableBridge.writeDouble(High, 4 + __off, 8, __dbStmt);
    JdbcWritableBridge.writeDouble(Low, 5 + __off, 8, __dbStmt);
    JdbcWritableBridge.writeDouble(Close, 6 + __off, 8, __dbStmt);
    JdbcWritableBridge.writeDouble(AdjClose, 7 + __off, 8, __dbStmt);
    JdbcWritableBridge.writeLong(Volume, 8 + __off, -5, __dbStmt);
    JdbcWritableBridge.writeString(tickt, 9 + __off, -1, __dbStmt);
    JdbcWritableBridge.writeTimestamp(updated_at, 10 + __off, 93, __dbStmt);
  }
  public void readFields(DataInput __dataIn) throws IOException {
this.readFields0(__dataIn);  }
  public void readFields0(DataInput __dataIn) throws IOException {
    if (__dataIn.readBoolean()) { 
        this.ID = null;
    } else {
    this.ID = Integer.valueOf(__dataIn.readInt());
    }
    if (__dataIn.readBoolean()) { 
        this.Date = null;
    } else {
    this.Date = new Timestamp(__dataIn.readLong());
    this.Date.setNanos(__dataIn.readInt());
    }
    if (__dataIn.readBoolean()) { 
        this.Open = null;
    } else {
    this.Open = Double.valueOf(__dataIn.readDouble());
    }
    if (__dataIn.readBoolean()) { 
        this.High = null;
    } else {
    this.High = Double.valueOf(__dataIn.readDouble());
    }
    if (__dataIn.readBoolean()) { 
        this.Low = null;
    } else {
    this.Low = Double.valueOf(__dataIn.readDouble());
    }
    if (__dataIn.readBoolean()) { 
        this.Close = null;
    } else {
    this.Close = Double.valueOf(__dataIn.readDouble());
    }
    if (__dataIn.readBoolean()) { 
        this.AdjClose = null;
    } else {
    this.AdjClose = Double.valueOf(__dataIn.readDouble());
    }
    if (__dataIn.readBoolean()) { 
        this.Volume = null;
    } else {
    this.Volume = Long.valueOf(__dataIn.readLong());
    }
    if (__dataIn.readBoolean()) { 
        this.tickt = null;
    } else {
    this.tickt = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.updated_at = null;
    } else {
    this.updated_at = new Timestamp(__dataIn.readLong());
    this.updated_at.setNanos(__dataIn.readInt());
    }
  }
  public void write(DataOutput __dataOut) throws IOException {
    if (null == this.ID) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.ID);
    }
    if (null == this.Date) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeLong(this.Date.getTime());
    __dataOut.writeInt(this.Date.getNanos());
    }
    if (null == this.Open) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeDouble(this.Open);
    }
    if (null == this.High) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeDouble(this.High);
    }
    if (null == this.Low) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeDouble(this.Low);
    }
    if (null == this.Close) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeDouble(this.Close);
    }
    if (null == this.AdjClose) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeDouble(this.AdjClose);
    }
    if (null == this.Volume) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeLong(this.Volume);
    }
    if (null == this.tickt) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, tickt);
    }
    if (null == this.updated_at) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeLong(this.updated_at.getTime());
    __dataOut.writeInt(this.updated_at.getNanos());
    }
  }
  public void write0(DataOutput __dataOut) throws IOException {
    if (null == this.ID) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.ID);
    }
    if (null == this.Date) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeLong(this.Date.getTime());
    __dataOut.writeInt(this.Date.getNanos());
    }
    if (null == this.Open) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeDouble(this.Open);
    }
    if (null == this.High) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeDouble(this.High);
    }
    if (null == this.Low) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeDouble(this.Low);
    }
    if (null == this.Close) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeDouble(this.Close);
    }
    if (null == this.AdjClose) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeDouble(this.AdjClose);
    }
    if (null == this.Volume) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeLong(this.Volume);
    }
    if (null == this.tickt) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, tickt);
    }
    if (null == this.updated_at) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeLong(this.updated_at.getTime());
    __dataOut.writeInt(this.updated_at.getNanos());
    }
  }
  private static final DelimiterSet __outputDelimiters = new DelimiterSet((char) 44, (char) 10, (char) 0, (char) 0, false);
  public String toString() {
    return toString(__outputDelimiters, true);
  }
  public String toString(DelimiterSet delimiters) {
    return toString(delimiters, true);
  }
  public String toString(boolean useRecordDelim) {
    return toString(__outputDelimiters, useRecordDelim);
  }
  public String toString(DelimiterSet delimiters, boolean useRecordDelim) {
    StringBuilder __sb = new StringBuilder();
    char fieldDelim = delimiters.getFieldsTerminatedBy();
    __sb.append(FieldFormatter.escapeAndEnclose(ID==null?"null":"" + ID, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(Date==null?"null":"" + Date, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(Open==null?"null":"" + Open, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(High==null?"null":"" + High, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(Low==null?"null":"" + Low, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(Close==null?"null":"" + Close, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(AdjClose==null?"null":"" + AdjClose, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(Volume==null?"null":"" + Volume, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(tickt==null?"null":tickt, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(updated_at==null?"null":"" + updated_at, delimiters));
    if (useRecordDelim) {
      __sb.append(delimiters.getLinesTerminatedBy());
    }
    return __sb.toString();
  }
  public void toString0(DelimiterSet delimiters, StringBuilder __sb, char fieldDelim) {
    __sb.append(FieldFormatter.escapeAndEnclose(ID==null?"null":"" + ID, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(Date==null?"null":"" + Date, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(Open==null?"null":"" + Open, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(High==null?"null":"" + High, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(Low==null?"null":"" + Low, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(Close==null?"null":"" + Close, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(AdjClose==null?"null":"" + AdjClose, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(Volume==null?"null":"" + Volume, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(tickt==null?"null":tickt, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(updated_at==null?"null":"" + updated_at, delimiters));
  }
  private static final DelimiterSet __inputDelimiters = new DelimiterSet((char) 44, (char) 10, (char) 0, (char) 0, false);
  private RecordParser __parser;
  public void parse(Text __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  public void parse(CharSequence __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  public void parse(byte [] __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  public void parse(char [] __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  public void parse(ByteBuffer __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  public void parse(CharBuffer __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  private void __loadFromFields(List<String> fields) {
    Iterator<String> __it = fields.listIterator();
    String __cur_str = null;
    try {
    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.ID = null; } else {
      this.ID = Integer.valueOf(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.Date = null; } else {
      this.Date = java.sql.Timestamp.valueOf(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.Open = null; } else {
      this.Open = Double.valueOf(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.High = null; } else {
      this.High = Double.valueOf(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.Low = null; } else {
      this.Low = Double.valueOf(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.Close = null; } else {
      this.Close = Double.valueOf(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.AdjClose = null; } else {
      this.AdjClose = Double.valueOf(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.Volume = null; } else {
      this.Volume = Long.valueOf(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null")) { this.tickt = null; } else {
      this.tickt = __cur_str;
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.updated_at = null; } else {
      this.updated_at = java.sql.Timestamp.valueOf(__cur_str);
    }

    } catch (RuntimeException e) {    throw new RuntimeException("Can't parse input data: '" + __cur_str + "'", e);    }  }

  private void __loadFromFields0(Iterator<String> __it) {
    String __cur_str = null;
    try {
    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.ID = null; } else {
      this.ID = Integer.valueOf(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.Date = null; } else {
      this.Date = java.sql.Timestamp.valueOf(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.Open = null; } else {
      this.Open = Double.valueOf(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.High = null; } else {
      this.High = Double.valueOf(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.Low = null; } else {
      this.Low = Double.valueOf(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.Close = null; } else {
      this.Close = Double.valueOf(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.AdjClose = null; } else {
      this.AdjClose = Double.valueOf(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.Volume = null; } else {
      this.Volume = Long.valueOf(__cur_str);
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null")) { this.tickt = null; } else {
      this.tickt = __cur_str;
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.updated_at = null; } else {
      this.updated_at = java.sql.Timestamp.valueOf(__cur_str);
    }

    } catch (RuntimeException e) {    throw new RuntimeException("Can't parse input data: '" + __cur_str + "'", e);    }  }

  public Object clone() throws CloneNotSupportedException {
    daily_stock o = (daily_stock) super.clone();
    o.Date = (o.Date != null) ? (java.sql.Timestamp) o.Date.clone() : null;
    o.updated_at = (o.updated_at != null) ? (java.sql.Timestamp) o.updated_at.clone() : null;
    return o;
  }

  public void clone0(daily_stock o) throws CloneNotSupportedException {
    o.Date = (o.Date != null) ? (java.sql.Timestamp) o.Date.clone() : null;
    o.updated_at = (o.updated_at != null) ? (java.sql.Timestamp) o.updated_at.clone() : null;
  }

  public Map<String, Object> getFieldMap() {
    Map<String, Object> __sqoop$field_map = new HashMap<String, Object>();
    __sqoop$field_map.put("ID", this.ID);
    __sqoop$field_map.put("Date", this.Date);
    __sqoop$field_map.put("Open", this.Open);
    __sqoop$field_map.put("High", this.High);
    __sqoop$field_map.put("Low", this.Low);
    __sqoop$field_map.put("Close", this.Close);
    __sqoop$field_map.put("Adj Close", this.AdjClose);
    __sqoop$field_map.put("Volume", this.Volume);
    __sqoop$field_map.put("tickt", this.tickt);
    __sqoop$field_map.put("updated_at", this.updated_at);
    return __sqoop$field_map;
  }

  public void getFieldMap0(Map<String, Object> __sqoop$field_map) {
    __sqoop$field_map.put("ID", this.ID);
    __sqoop$field_map.put("Date", this.Date);
    __sqoop$field_map.put("Open", this.Open);
    __sqoop$field_map.put("High", this.High);
    __sqoop$field_map.put("Low", this.Low);
    __sqoop$field_map.put("Close", this.Close);
    __sqoop$field_map.put("Adj Close", this.AdjClose);
    __sqoop$field_map.put("Volume", this.Volume);
    __sqoop$field_map.put("tickt", this.tickt);
    __sqoop$field_map.put("updated_at", this.updated_at);
  }

  public void setField(String __fieldName, Object __fieldVal) {
    if (!setters.containsKey(__fieldName)) {
      throw new RuntimeException("No such field:"+__fieldName);
    }
    setters.get(__fieldName).setField(__fieldVal);
  }

}

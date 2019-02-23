### modify RPC struct, Using Google ![Grpc](https://grpc.io/)

#### grpc data type support

|proto Type | Java Type | Document |
|:---------:| :--------:| :-------:|
|double     | double    |          |
|float      | float     |          |
|int32      | int       |使用可变长编码方式。编码负数时不够高效——如果你的字段可能含有负数，那么请使用sint32。          |
|int64      | long      |使用可变长编码方式。编码负数时不够高效——如果你的字段可能含有负数，那么请使用sint64。          |
|uint32     | int[1]    |Uses variable-length encoding.         |
|uint64     | long[1]   |Uses variable-length encoding.          |
|sint32     | int       |使用可变长编码方式。有符号的整型值。编码时比通常的int32高效。          |
|sint64     | long      |使用可变长编码方式。有符号的整型值。编码时比通常的int64高效。          |
|fixed32    | uint32    |总是4个字节。如果数值总是比总是比2<sup>28</sup>大的话，这个类型会比uint32高效。          |
|fixed64    | uint64    |总是8个字节。如果数值总是比总是比256大的话，这个类型会比uint64高效。          |
|sfixed32   | int       |总是4个字节          |
|sfixed64   | long      |总是8个字节          |
|bool       | boolean   |          |
|string     | String    |一个字符串必须是UTF-8编码或者7-bit ASCII编码的文本。          |
|bytes      | ByteString|可能包含任意顺序的字节数据。          |



